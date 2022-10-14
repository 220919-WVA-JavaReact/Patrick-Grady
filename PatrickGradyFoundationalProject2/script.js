let endpoint = "http://localhost:8080/ticket";
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
axios.defaults.headers.post['Content-Type'] = 'text/html';


const getUsers = () => {
    axios.get(endpoint)
    .then(response => {
     const info = response.data.data;
     console.log(info);
   })
    .catch(error => console.error(error));
   };
   getUsers();