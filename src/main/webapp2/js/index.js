
var leftmenu = new Vue({
	el : '#leftmenu',
	data : {
		platforms : [ {
			id : 1,
			name : 'PS4'
		}, {
			id : 2,
			name : 'PC'
		}, {
			id : 3,
			name : 'Switch'
		} ]
	}
})

export default {
  data: () => ({
    posts: [],
    errors: []
  }),

  // Fetches posts when the component is created.
  created() {
	    axios.get(`/genres/list`)
	    .then(response => {
	      // JSON responses are automatically parsed.
	      leftmenu.data.genres = response.data
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

