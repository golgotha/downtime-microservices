import React, {Component} from 'react';
import EventsComponent from "../components/EventsComponent";

export default class MainApp extends Component {

    constructor(props) {
        super(props);
        this.state = {events: []}
    }

    componentDidMount() {
        fetch('http://localhost:3000/scheduler/events')
            .then(response => {
                console.log(response);
                response.json().then(result => this.setState({events: result}));
            })
            .catch(e => {
                this.setState({events: []});
            })
    }

    render() {
        return (
            <div>
                <h1>Events</h1>
                <EventsComponent events={this.state.events}/>
            </div>
        )
    }
}