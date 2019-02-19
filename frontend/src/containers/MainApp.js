import React, {Component} from 'react';
import EventsComponent from "../components/EventsComponent";
import TicketsComponent from "../components/TicketsComponent";

export default class MainApp extends Component {

    constructor(props) {
        super(props);
        this.state = {
            events: [],
            tickets: [],
            selected: 'v2'
        }
    }

    componentDidMount() {
        this.requestEvents();
    }

    requestEvents = () => {
        fetch('http://localhost:3000/scheduler/events')
            .then(response => {
                response.json().then(result => {
                    console.debug(result);
                    this.requestTickets();
                    if (response.status >= 400) {
                        return Promise.reject("API is not available");
                    }
                    this.setState({events: result});
                    const offset = Math.abs(result[0].startTime - result[0].serverTime);
                    console.debug(offset);
                    this.timerId = setTimeout(this.requestEvents, offset);
                });
            })
            .catch(e => {
                this.setState({events: []});
            });
    };

    requestTickets = () => {
        fetch(`http://localhost:3000/${this.state.selected}/accept/findTickets`)
            .then(response => {
                console.log(response)
                if (response.status >= 400) {
                    return Promise.reject("API is not available");
                } else {
                    return response.json()
                }
            })
            .then(result => {
                this.setState({tickets: result})
            })
            .catch(e => this.setState({tickets: []}))
    };

    componentWillUnmount() {
        clearTimeout(this.timerId);
    }

    onChangeVersionHandler = (event) => {
        this.setState({selected: event.target.value})
    };

    onTicketBookedHandler = () => {
        this.requestTickets();
    };

    render() {
        return (
            <div>
                <span>API version: </span>
                <select onChange={this.onChangeVersionHandler}
                        defaultValue={this.state.selected}>
                    <option value="v1">v1</option>
                    <option value="v2">v2</option>
                </select>

                <div style={{display: 'flex', flex: '1 0 0'}}>
                    <div style={{display: 'block', marginRight: "100px"}}>
                        <h1>Events</h1>
                        <div style={{display: 'block', width: "100%"}}>
                            <EventsComponent events={this.state.events}
                                             apiVersion={this.state.selected}
                                             onTicketBooked={this.onTicketBookedHandler}
                            />
                        </div>
                    </div>
                    <div style={{display: 'block'}}>
                        <h1>Tickets</h1>
                        <div style={{display: 'block'}}>
                            <TicketsComponent tickets={this.state.tickets}/>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}