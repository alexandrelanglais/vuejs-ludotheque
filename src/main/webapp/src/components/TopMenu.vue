<template>
    <nav class="navbar navbar-inverse" role="navigation">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <router-link class="navbar-brand" to="/">Ludothèque</router-link>
          <router-link class="navbar-brand" to="/addGenre">Ajouter un genre</router-link>
          <router-link class="navbar-brand" to="/addPlatform">Ajouter une plate-forme</router-link>
          <router-link class="navbar-brand" to="/addGame">Ajouter un jeu</router-link>
          <router-link class="navbar-brand" to="/about">A propos</router-link>
        </div>
      </div>
    </nav>
</template>

<script>
export default {
  name: 'topmenu',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
