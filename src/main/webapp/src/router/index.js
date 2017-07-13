import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home'
import About from '@/pages/About'
import GamesByGenre from '@/pages/GamesByGenre'
import GamesByPlatform from '@/pages/GamesByPlatform'
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
    },
    {
      path: '/games/bygenre',
      name: 'GamesByGenre',
      component: GamesByGenre
    },
    {
      path: '/games/byplatform',
      name: 'GamesByPlatform',
      component: GamesByPlatform
    }
  ]
})
