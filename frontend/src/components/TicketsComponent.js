import React, {PureComponent} from 'react';
import PT from 'prop-types';

export default class TicketsComponent extends PureComponent {
    static propTypes = {
        tickets: PT.array
    };

    constructor(props) {
        super(props);
        this.state = {selected: 'v2'};
    }
    componentDidMount() {

    }

    render() {
        const {tickets} = this.props;
        return (
            <div>

            </div>
        )
    }

}