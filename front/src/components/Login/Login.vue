<template>
  <div id="login">
    <!--<button class="loginBtn loginBtn&#45;&#45;facebook">-->
    <!--Login with Facebook-->
    <!--</button>-->
    <p>{{message}}</p>
    <button class="loginBtn loginBtn--google" v-on:click="googleLogin()">
      Login with Google
    </button>


    <!--test code-->
    <!--It will be removed later-->
    <md-field style="width:30%;margin: 0 auto">
      <label>SimpleLogin</label>
      <md-input v-model="username"></md-input>
    </md-field>
    <md-button class="md-raised" v-on:click="simpleLogin">simple login</md-button>

  </div>

</template>

<script>
  export default {
    name: 'Login',
    created: function () {
      // alert('this is login page!')
    },
    data: function () {
      return {
        message: 'this is login page',
        username:''
      }
    },
    methods: {
      googleLogin: function () {
        const loginUri = '/login/google'
        location.href = loginUri
      },
      simpleLogin: function () {
        // this function will be removed
        // simple login for application test
        const loginUri = '/login/simple'
        let data = {
          username:this.username
        }

        this.axios.post(loginUri,data).then(()=>{
          location.href = '/'
        })

      }
    }
  }
</script>

<style scoped>
  body {
    padding: 2em;
  }

  /* Shared */
  .loginBtn {
    box-sizing: border-box;
    position: relative;
    /* width: 13em;  - apply for fixed size */
    margin: 0.2em;
    padding: 0 15px 0 46px;
    border: none;
    text-align: left;
    line-height: 34px;
    white-space: nowrap;
    border-radius: 0.2em;
    font-size: 16px;
    color: #FFF;
  }

  .loginBtn:before {
    content: "";
    box-sizing: border-box;
    position: absolute;
    top: 0;
    left: 0;
    width: 34px;
    height: 100%;
  }

  .loginBtn:focus {
    outline: none;
  }

  .loginBtn:active {
    box-shadow: inset 0 0 0 32px rgba(0, 0, 0, 0.1);
  }

  /* Google */
  .loginBtn--google {
    /*font-family: "Roboto", Roboto, arial, sans-serif;*/
    background: #DD4B39;
  }

  .loginBtn--google:before {
    border-right: #BB3F30 1px solid;
    background: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/14082/icon_google.png') 6px 6px no-repeat;
  }

  .loginBtn--google:hover,
  .loginBtn--google:focus {
    background: #E74B37;
  }

  /* Facebook */
  .loginBtn--facebook {
    background-color: #4C69BA;
    background-image: linear-gradient(#4C69BA, #3B55A0);
    /*font-family: "Helvetica neue", Helvetica Neue, Helvetica, Arial, sans-serif;*/
    text-shadow: 0 -1px 0 #354C8C;
  }

  .loginBtn--facebook:before {
    border-right: #364e92 1px solid;
    background: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/14082/icon_facebook.png') 6px 6px no-repeat;
  }

  .loginBtn--facebook:hover,
  .loginBtn--facebook:focus {
    background-color: #5B7BD5;
    background-image: linear-gradient(#5B7BD5, #4864B1);
  }
</style>
