<template>
<div>
  <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" style="background: #afe8bb;border: 0px;">
    <el-row :gutter="20">
      <el-col :span="12">
        <div class="grid-content bg-purple" style="text-align:center ;" >
        <el-menu-item index="1" style="color: #4a6575;border-radius: 25px;" class="xf" @click="show1" >
          <div style="font-size: 30px">
            照片墙
          </div>
        </el-menu-item>
      </div></el-col>
      <el-col :span="12"><div class="grid-content bg-purple">
        <div style="text-align:center">
          <el-menu-item index="2" style="color: #4a6575 ;border-radius: 25px; "class="xf" @click="show2">
            <div style="font-size: 30px">
              成绩单
            </div>
          </el-menu-item>
        </div>
      </div></el-col>
      <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
    </el-row>
    <hr style="background: #ea3434;height: 8px;border: 10px;border: #ddbbdd;border-radius: 25px;">
  </el-menu>
<!--  根据 设定 展示照片墙 和成绩单-->
  <div style="height: 20px"></div>
  <div style="text-align: center">
    <div v-if="flag"><PhotoWall></PhotoWall></div>
    <div v-if="!flag"><Results></Results></div>
  </div>
</div>
</template>

<script>
import PhotoWall from "@/components/home/PhotoWall";
import Results from "@/components/home/results";
export default {
  name: "home",
  components: {
    Results,
    PhotoWall
  },
  data(){
    return{
      flag:true
    }
  },
  methods:{
    show1(){
      this.flag = true;
    },
    show2(){
      this.flag = false;
    }
  },
}
</script>

<style>
.xf:hover{
  background: #fcfaed;
}
</style>
