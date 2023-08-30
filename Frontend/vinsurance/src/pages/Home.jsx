import React from 'react'
import img from '../assets/images/home.png'
import '../styles/home.css'
import Login from './Login'
const Home = () => {
  return (
    <div className='home-container'>
      <div className='home-img'>
        <img src={img}/>
      </div>
      <div className='login-form'>
        <h4>Login</h4>
        <Login/>
      </div>

    </div>
  )
}

export default Home
