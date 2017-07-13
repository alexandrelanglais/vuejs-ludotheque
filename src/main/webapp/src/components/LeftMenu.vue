<template>
<div class="col-md-3" id="leftmenu">
  <p class="lead">Genres</p>
  <div class="list-group" v-for="genre in genres">
    <router-link :to="{path: '/games/bygenre', query: {id: genre.id}}" class="list-group-item">{{genre.name}}</router-link>
  </div>
  <p class="lead">Plate-formes</p>
  <div class="list-group" v-for="platform in platforms">
    <router-link :to="{path: '/games/byplatform', query: {id: platform.id}}" class="list-group-item">{{platform.name}}</router-link>
  </div>
</div>
</template>
<script>
import axios from 'axios'

export default {
  data: () => ({
    genres: [],
    platforms: [],
    errors: []
  }),

  // Fetches posts when the component is created.
  created () {
    axios.get('http://localhost:8080/genres/list')
    .then(response => {
      // JSON responses are automatically parsed.
      this.genres = response.data
    })
    .catch(e => {
      this.errors.push(e)
    })
    axios.get('http://localhost:8080/platforms/list')
    .then(response => {
      // JSON responses are automatically parsed.
      this.platforms = response.data
    })
    .catch(e => {
      this.errors.push(e)
    })

    // async / await version (created() becomes async created())
    //
    // try {
    //   const response = await axios.get(`http://jsonplaceholder.typicode.com/posts`)
    //   this.posts = response.data
    // } catch (e) {
    //   this.errors.push(e)
    // }
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
