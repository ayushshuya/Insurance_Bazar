import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Home from '../pages/Home'
import Signup from '../pages/Signup'
import Admin from '../pages/Admin'
import Vehicle from '../pages/Vehicle'
import Policy from '../pages/Policy'
import Booked from '../pages/Booked'

import Getuser from '../components/Admin/Getuser'

const Routers = () => {
  return (
    <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/home' element={<Home/>}/>
        <Route path='/signup' element={<Signup/>}/>
        <Route path='/admin' element={<Admin/>}/>
        <Route path='/vehicle' element={<Vehicle/>}/>
        <Route path='/policy' element={<Policy/>}/>
        
        <Route path='/getuser' element={<Getuser/>}/>
        <Route path='/booked' element={<Booked/>}/>
    </Routes>
  )
}

export default Routers
