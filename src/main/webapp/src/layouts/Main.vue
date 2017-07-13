<template>
  <div class="container">
    <top-menu></top-menu>
    <div class="row">
      <left-menu></left-menu>
      <slot></slot>
    </div>
  </div>
</template>

<script>
import LeftMenu from '../components/LeftMenu.vue'
import TopMenu from '../components/TopMenu.vue'

export default {
  components: {
    LeftMenu,
    TopMenu
  }
}
</script>

<style scoped>
</style>
