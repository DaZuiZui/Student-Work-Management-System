<template>
<div>
  <el-container>
    <el-container>
      <div class="myUL">
        <el-aside width="200px" class="myUL">
          <el-menu
              :default-active="activeIndex"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose" style="height: 695px">
            <div style="height: 100px"></div>
            <el-submenu index="1">
              <template slot="title">
                <span>用户管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="1-1" @click="activeIndex='1-1'">学生管理</el-menu-item>
                <el-menu-item @click="activeIndex='1-2'" index="1-2" >家长管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-menu-item index="2" @click="activeIndex='2'">
              <span slot="title">作业管理</span>
            </el-menu-item>
            <el-menu-item index="4" @click="activeIndex='3'">
              <span slot="title" >作业批阅</span>
            </el-menu-item>
            <el-menu-item index="5" @click="activeIndex='4'">
              <span slot="title" >更新成绩单</span>
            </el-menu-item>
            <el-menu-item style="margin-top: 40px" @click="exit">
              <div style="color: red"> 退出登录</div>
            </el-menu-item>
          </el-menu>
        </el-aside>
      </div>
      <el-main>
        <div v-if="activeIndex==='1-1'">
          <student></student>
        </div>
        <div v-if="activeIndex==='1-2'">
          <ParentsManagement></ParentsManagement>
        </div>
        <div v-if="activeIndex==='2'">
          <Homework></Homework>
        </div>
        <div v-if="activeIndex==='3'">
          <batchHomeWork></batchHomeWork>
        </div>
        <div v-if="activeIndex==='4'">
          <updateResults></updateResults>
        </div>


      </el-main>
    </el-container>
  </el-container>
</div>
</template>

<script>
import Student from "@/components/admin/management/Student";
import ParentsManagement from "@/components/admin/management/ParentsManagement";
import Homework from "@/components/admin/management/homework";
import batchHomeWork from "@/components/admin/management/batchHomeWork";
import updateResults from "@/components/admin/management/updateResults";
export default {
  name: "adminHome",
  data(){
    return{
      activeIndex:'0'
    }
  },
  methods:{
    test(){
      alert(this.activeIndex)
    },
    exit(){
      this.$router.push({
        path:'/adminlogin'
      })
    }
  },
  components:{
    Student,
    ParentsManagement,
    Homework,
    updateResults,
    batchHomeWork
  },
  created() {
    if (this.$store.state.username == null) {
      this.$router.push({
        path:'/'
      })
    }
  }
}
</script>

<style scoped>

</style>
