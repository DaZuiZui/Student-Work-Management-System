<template>
  <div id="app" >
  <router-view></router-view>
  </div>
</template>

<script>

import Login from './components/login'
import Reg from './components/reg'
export default {
  name: 'App',
  components: {
    Login,
    Reg
  }
}
</script>

<style>
#app {
}
/*div{*/
/*  width: 500px;*/
/*  height:500px;*/
/*  margin:10px;*/
/*  background: -webkit-linear-gradient(top,red,white,blue);*/
/*  background: -moz-linear-gradient(top,red,white,blue);*/
/*}*/
.test{
  width:100%;
  height: 100%;
  background-image: linear-gradient(to bottom right, #01b8a3, #018db4);                  /*默认是从上到下的渐变*/
  /*background-image: linear-gradient(to top, black, red);*/      /*从下到上的渐变*/
  /*background-image: linear-gradient(to right, black, red);*/    /*从左到右的渐变*/
  /*background-image: linear-gradient(to left, black, red);*/     /*从右到左的渐变*/
}

</style>
