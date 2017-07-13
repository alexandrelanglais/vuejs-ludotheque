<template>
  <main-layout>
    <p>Jeux par genre</p>
    <div class="col-sm-4 col-lg-4 col-md-4" v-for="game in games">
      <div class="thumbnail">
          <img src="http://placehold.it/320x150" alt="">
          <div class="caption">
              <h4 class="pull-right">$24.99</h4>
              <h4><a href="#">{{game.name}}</a>
              </h4>
              <router-link :to="{name: '/games/get/', params: {id: game.id}}" class="list-group-item">{{game.name}}</router-link>
              <p>See more snippets like this online store item at <a target="_blank" href="http://www.bootsnipp.com">Bootsnipp - http://bootsnipp.com</a>.</p>
          </div>
      </div>
    </div>
  </main-layout>
</template>

<script>
  import axios from 'axios'
  import MainLayout from '../layouts/Main.vue'

  export default {
    components: {
      MainLayout
    },
    data: () => ({
      games: [],
      errors: []
    }),
    created () {
      axios.get('http://localhost:8080/games/listByGenre?genreId=' + this.$route.query.id)
      .then(response => {
        // JSON responses are automatically parsed.
        this.games = response.data
      })
      .catch(e => {
        this.errors.push(e)
      })
    }
  }
</script>
