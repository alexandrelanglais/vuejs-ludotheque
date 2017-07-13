<template>
</template>


<template>
  <main-layout>
    <p>Add a game</p>
    <div>
      <input type="text" v-model="gameName"/>
      Genre:
      <select v-model="genreId">
        <option v-for="genre in genres" v-bind:value="genre.id">
		    {{ genre.name }}
        </option>
      </select>      
      Genre:
      <select v-model="platformId">
        <option v-for="platform in platforms" v-bind:value="platform.id">
        {{ platform.name }}
        </option>
      </select>      
      <input type="button" v-on:click="postForm" value="Ajouter"/>
      <span v-model="response"></span>
      <ul v-if="errors && errors.length">
        <li v-for="error of errors">
          {{error.message}}
        </li>
      </ul>
    </div>
  </main-layout>
</template>

<script>
import MainLayout from '../layouts/Main.vue'
import axios from 'axios'

export default {
  components: {
    MainLayout
  },
  data: () => ({
    gameName: '',
    genreId: '',
    platformId: '',
    response: '',
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

    axios.get('http://localhost:8080/platforms/list')
      .then(response => {
        // JSON responses are automatically parsed.
        this.platforms = response.data
      })
      .catch(e => {
        this.errors.push(e)
  },
  methods: {
    // Pushes posts to the server when called.
    postForm () {
      axios.post('http://localhost:8080/games/add', {
        name: this.gameName,
        genre: {
          id: this.genreId
        },
        platform: {
          id: this.platformId
        }
      })
      .then(response => {
        this.response = response.data
      })
      .catch(e => {
        this.errors.push(e)
      })
    }
  }
}
</script>
