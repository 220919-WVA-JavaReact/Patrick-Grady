import React from 'react';
import logo from './logo.svg';
import './App.css';
import Nav from './components/nav/Nav';
import Home from './components/home/Home';
import TTAAL from './components/ttaal/TTAAL';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <>
      <BrowserRouter>
        <Nav />
        <Routes>
          <Route path='/' element={<Home />}></Route>
          <Route path='/ttaal' element={<TTAAL />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
