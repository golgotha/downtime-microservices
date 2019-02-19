import React, {PureComponent} from 'react';
import PT from 'prop-types';
import Event from './Event';

export default class EventsComponent extends PureComponent {
    static propTypes = {
        events: PT.array,
        apiVersion: PT.string,
        onTicketBooked: PT.func
    };

    constructor(props) {
        super(props);
    }

    componentDidMount() {

    }

    onBookClickHandler = (eventId) => {
        fetch(`/${this.props.apiVersion}/accept/book`, {
            method: "POST",
            mode: "cors", // no-cors, cors, *same-origin
            cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
            credentials: "same-origin", // include, *same-origin, omit
            headers: {
                "Content-Type": "application/json",
            },
            redirect: "follow", // manual, *follow, error
            referrer: "no-referrer", // no-referrer, *client
            body: JSON.stringify({
                eventId
            })
        }).then(response => {
            response.json().then(result => {
                window.alert('Ticket Id => ' + result.ticketId);
                this.props.onTicketBooked();
            });
        });
    };

    render() {
        const {events} = this.props;
        return (
                <table>
                    <thead>
                    <tr>
                        <th>Event id</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        events.map(event => {
                            return <Event eventId={event.eventId}
                                          status={event.status}
                                          key={event.eventId}
                                          onBookClick={this.onBookClickHandler}
                            />
                        })
                    }
                    </tbody>
                </table>
        )
    }

}