import React, {PureComponent} from 'react';
import PT from 'prop-types';
import TicketRow from './TicketRow';

export default class TicketsComponent extends PureComponent {
    static propTypes = {
        tickets: PT.array
    };

    render() {
        const {tickets} = this.props;
        return (
            <table>
                <thead>
                <tr>
                    <th>Ticket id</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                {
                    tickets.map(ticket => {
                        return <TicketRow ticketId={ticket.ticketId}
                                          status={ticket.status}
                                          key={ticket.ticketId}
                        />
                    })
                }
                </tbody>
            </table>
        )
    }

}