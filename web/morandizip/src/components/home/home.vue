<template>
<div>
  <el-container>
    <el-container>
      <div class="myUL">
        <el-aside width="200px" class="myUL">
          <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose" style="height: 695px" router>
            <div style="height: 100px"></div>
            <el-menu-item index="/home/homework">
              <span slot="title">作业信息</span>
            </el-menu-item>
            <el-menu-item index="/home/photowall">
              <span slot="title">照片墙</span>
            </el-menu-item>
            <el-menu-item index="/home/user">
              <span slot="title">查看个人信息</span>
            </el-menu-item>
            <el-menu-item index="/home/leaguetables">
              <span slot="title">成绩表</span>
            </el-menu-item>
            <el-menu-item v-if="this.$store.state.role == 'guardian'" index="/home/sonHomeWork">
              <span slot="title">我的孩子的作业</span>
            </el-menu-item>
            <el-menu-item style="margin-top: 40px" @click="exit">
             <div style="color: red"> 退出登录</div>
            </el-menu-item>
          </el-menu>
        </el-aside>
      </div>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>

</div>
</template>

<script>
import Content from './content'
import User from "@/components/home/user";
export default {
  name: "home",
  components:{
    Content,
    User
  },
  created() {
    if (this.$store.state.username == null){
      this.$router.push({
        path:'/'
      })
    }
  },
  methods:{
    exit(){
      this.$router.push({
        path:'/'
      })
    }
  }
}
</script>

<style>
.myUL{
  border-radius: 25px;
}
.myUL > ul{
  border-radius: 25px;
}
   .myUL > ul :hover{
     border-radius: 25px;
   }
.myUL > ul :focus {
  border-radius: 25px;
}

</style>
