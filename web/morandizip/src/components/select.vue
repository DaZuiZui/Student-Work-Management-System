<template>
<div>

  <div >
    <div style="height: 120px"></div>
    <el-row :gutter="20">
      <el-col :span="5"><div class="grid-content bg-purple">&nbsp;</div></el-col>
      <el-col :span="14"><div class="grid-content bg-purple">
        <div class="mydiv">
          <el-card shadow="never">
            <el-row :gutter="20">
              <el-col :span="12"><div class="grid-content bg-purple">
                <el-card shadow="hover" style="margin: 0 auto; text-align: center;border: 3px solid #d5cdfc;">
                  <div style="margin: 15px">
                    <el-image :src="src1" ></el-image>
                  </div>
                  我是学生
                 <div style="margin: 15px">
                   <el-button @click="studentsReg" type="primary" plain style="color: white; background: #ddbbdd;border: 0px">继续</el-button>
                 </div>
                </el-card>

              </div></el-col>
              <el-col :span="12"><div class="grid-content bg-purple">
<!--                #935555-->
                <el-card shadow="hover" style="border: 3px solid #dbd1c5;">
                  <div style="margin: 0 auto; text-align: center">
                    <div style="margin: 15px">
                      <el-image :src="src2" ></el-image>
                    </div>

                    我是家长
                    <div style="margin: 15px">
                      <el-button type="primary" plain style="color: white; background: #ddbbdd;border: 0px" @click="parentsReg">继续</el-button>
<!--                      <el-button type="text" @click="open">点击打开 Message Box</el-button>-->
                    </div>
                  </div>

                </el-card>
              </div></el-col>
            </el-row>
          </el-card>
        </div>

      </div></el-col>
    </el-row>

  </div>

</div>
</template>

<script>
import parents from '/public/parents.png'
import student from '/public/student.png'
export default {
  name: "select",
  data() {
    return {
      src1:student,
      src2: parents,
      user:'张三'
    }
  },
  methods: {
    studentsReg(){
      this.$router.push({
        path:'/reg',
        query:{
          role:'student'
        }
      })
    },
    //studentsReg
    // parents
    parentsReg(){
      this.$router.push({
        path:'/reg',
        query:{
          role:'parents'
        }
      })
    }
  }
}
</script>

<style>
.myXZ > button{

}
</style>
