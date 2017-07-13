import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home'
import About from '@/pages/About'
import GamesByGenre from '@/pages/GamesByGenre'
import AddGenre from '@/pages/AddGenre'
import AddPlatform from '@/pages/AddPlatform'
import AddGame from '@/pages/AddGame'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/about',
      name: 'About',
      component: About
    },
    {
      path: '/games/bygenre/:id',
      name: 'GamesByGenre',
      component: GamesByGenre
    },
    {
      path: '/addGenre',
      name: 'AddGenre',
      component: AddGenre
    },
    {
      path: '/addPlatform',
      name: 'AddPlatform',
      component: AddPlatform
    },
    {
      path: '/addGame',
      name: 'AddGame',
      component: AddGame
    }
  ]
})
