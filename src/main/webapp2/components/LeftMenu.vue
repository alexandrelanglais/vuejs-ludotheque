<template>
  <div class="col-md-3" id="leftmenu">
    <p class="lead">Genres</p>
    <div class="list-group" v-for="genre in genres">
      <a v-bind:href="'/games/bygenre/' + genre.id" class="list-group-item">{{genre.name}}</a>
    </div>
    <p class="lead">Plate-formes</p>
    <div class="list-group" v-for="platform in platforms">
      <a v-bind:href="'/games/byplatform/' + platform.id" class="list-group-item">{{platform.name}}</a>
    </div>
  </div>
  <slot></slot>
</template>