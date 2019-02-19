import React, {PureComponent} from 'react';
import PT from 'prop-types';

export default class TicketRow extends PureComponent {
    static propTypes = {
        ticketId: PT.number,
        status: PT.string
    };

    render() {
        const {ticketId, status} = this.props;
        return (
            <tr>
                <td>{ticketId}</td>
                <td>{status}</td>
            </tr>
        )
    }

}