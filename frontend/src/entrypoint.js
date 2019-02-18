import React from 'react';
import ReactDOM from 'react-dom';
import MainApp from './containers/MainApp';

function render() {
    const container = document.getElementById("root");
    ReactDOM.render(<MainApp/>, container);
}

render();

if (module.hot) {
    module.hot.accept('./entrypoint.js', () => {
        render();
    });
}