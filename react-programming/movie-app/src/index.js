import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
// import App from './movie-app';
// import App from './MovieApp2';
import App from './MovieApp4';
import reportWebVitals from './reportWebVitals';
import {DevSupport} from "@react-buddy/ide-toolbox";
import {ComponentPreviews, useInitial} from "./dev";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <DevSupport ComponentPreviews = {ComponentPreviews}
                useInitialHook = {useInitial}
    >
      <App />
    </DevSupport>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();