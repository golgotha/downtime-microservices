import React, {PureComponent} from 'react';
import PT from 'prop-types';
import Event from './Event';

export default class EventsComponent extends PureComponent {
    static propTypes = {
        events: PT.array
    };

    constructor(props) {
        super(props);
        this.state = {selected: 'v2'};
    }

    componentDidMount() {

    }

    onChangeVersionHandler = (event) => {
        this.setState({selected: event.target.value})
    };

    onBookClickHandler = (eventId) => {
        return fetch(`/${this.state.selected}/accept/book`, {
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
        })
    };

    render() {
        const {events} = this.props;
        return (
            <div>
                <span>API version: </span>
                <select onChange={this.onChangeVersionHandler}
                        defaultValue={this.state.selected}>
                    <option value="v1">v1</option>
                    <option value="v2">v2</option>
                </select>
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
                                          onBookClick={this.onBookClickHandler}
                            />
                        })
                    }
                    </tbody>
                </table>
            </div>
        )
    }

}