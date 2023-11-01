import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'

import { BrowserRouter } from 'react-router-dom' 

import Modal from 'react-modal';

// Set the app element
Modal.setAppElement('#root');

ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter basename = '/'>
    <App />
  </BrowserRouter>
)
