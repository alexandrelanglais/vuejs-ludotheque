<template>
</template>


<template>
  <main-layout>
    <p>Add a platform</p>
    <div>
      Nom: <input type="text" v-model="platformName"/>
      Constructeur: <input type="text" v-model="platformConstructor"/>
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
    platformName: '',
    platformConstructor: '',
    response: '',
    errors: []
  }),
  methods: {
    // Pushes posts to the server when called.
    postForm () {
      axios.post('http://localhost:8080/platforms/add', {
        name: this.platformName,
        constructor: this.platformConstructor
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
