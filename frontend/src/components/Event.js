import React, {PureComponent} from 'react';
import PT from 'prop-types';

export default class Event extends PureComponent {
    static propTypes = {
        eventId: PT.number,
        status: PT.string,
        onBookClick: PT.func
    };

    render() {
        const {eventId, status, onBookClick} = this.props;
        return (
            <tr>
                <td>{eventId}</td>
                <td>{status}</td>
                <td>
                    <button onClick={() => onBookClick(eventId)}>Book Ticket</button>
                </td>
            </tr>
        )
    }

}