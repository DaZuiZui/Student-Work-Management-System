<template>
<div>
  <el-row :gutter="20">
    <el-col :span="3"><div class="grid-content bg-purple">&nbsp;</div></el-col>
    <el-col :span="15"><div class="grid-content bg-purple">
      <div style="height: 60px"></div>
      <div style="text-align: center;color: black" class="mydiv">
        <el-card shadow="always">
          <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
            <el-form-item label="账号" style="width: 550px">
              <el-row :gutter="20">
                <el-col :span="11"><div class="grid-content bg-purple">
                  <el-input
                      placeholder="请输入内容"
                      v-model="this.$store.state.username"
                      :disabled="true">
                  </el-input>
                </div></el-col>
                <el-col :span="6"><div class="grid-content bg-purple">
                  <el-button type="primary" round @click="drawer=true" style="margin-left: 15px">修改密码</el-button>
                </div></el-col>
              </el-row>


            </el-form-item>
            <el-form-item label="名称">
              <div >
                <el-row :gutter="20">
                  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
                  <el-col :span="9"><div class="grid-content bg-purple">
                    <el-input class="lin" v-model="name" placeholder="编辑修改您的姓名" ></el-input>
                  </div></el-col>
                  <el-col :span="6"><div class="grid-content bg-purple">
                    <el-button type="primary" round @click="updatename">修改名称</el-button>
                  </div></el-col>
                </el-row>

              </div>
            </el-form-item>
            <el-form-item label="头像">
              <div>
                <el-row :gutter="20">
                  <el-col :span="7"><div class="grid-content bg-purple">
                    <div style="margin-left: 65px">
                      <el-avatar style="height: 80px;width: 80px" :src="this.$store.state.imaurl"></el-avatar>
                    </div>

                  </div></el-col>
                  <el-col :span="10" style="margin-top: 6px">
                    <div class="grid-content bg-purple" style="height: 30px">
                      <el-upload
                          class="upload-demo"
                          :action="'http://127.0.0.1:8989/uploadimage?username='+this.$store.state.username"
                          name="files"
                          :on-preview="handlePreview"
                          :on-remove="handleRemove"
                          :before-remove="beforeRemove"
                          multiple
                          :limit="3"
                          :on-success="yes"
                          :on-exceed="handleExceed"
                          :file-list="fileList">
                        <el-button   round type="primary">修改头像</el-button>
                      </el-upload>
                  </div></el-col>
                </el-row>
              </div>
            </el-form-item>
          </el-form>
        </el-card>
      </div>
    </div></el-col>
  </el-row>
  <el-drawer
      title="修改密码"
      :visible.sync="drawer"
      :direction="direction"
      :before-close="handleClose">
    <el-row :gutter="20">
      <el-col :span="5"><div class="grid-content bg-purple">&nbsp;</div></el-col>
      <el-col :span="13"><div class="grid-content bg-purple">
        <el-input  class="lin" placeholder="请输入密码" v-model="updatate.password1" show-password style="margin: 7px"></el-input>
        <el-input  class="lin" placeholder="请输入密码" v-model="updatate.password2" show-password style="margin: 7px"></el-input>
        <el-row :gutter="20" style="margin-top: 5px">
          <el-col :span="8"><div class="grid-content bg-purple">&nbsp;</div></el-col>
          <el-col :span="6"><div class="grid-content bg-purple">
            <el-button type="success" round @click="updatatePassword">修改密码</el-button>
          </div></el-col>
        </el-row>
      </div></el-col>
    </el-row>

  </el-drawer>

</div>
</template>

<script>
import tux  from '/public/parents.png'
export default {
  name: "user",
  data(){
    return{
      name:'',
      drawer : false,
      tu:tux,
      value:'',
      labelPosition: 'right',
      formLabelAlign: {
        name: '小明',
        region: '',
        type: '',
        username:'123456'
      },
      updatate:{
        password1:'',
        password2:''
      }
    }
  },
  methods: {
    yes(response, file, fileList){
      this.$message.success("重新登入后可查看")
    },
    updatepassword() {
      let url = '/user/updatePassword?username=' + this.$store.state.username + '&password='
      this.$axios('/user/updatePassword').then(res => {
        if (res.data == true) {
          this.$message.success("修改密码成功");
        }
      })
    },
    updatename(){
      this.$axios('/user/updatename?username='+this.$store.state.username+"&name="+this.name).then(res=>{
        if (res.data == true || res.data == 'true'){
          this.$message.success("修改成功")
        }else {
          this.$message.error("修改失败")
        }
      })
    },
    updatatePassword(){
      if (this.updatate.password1 != this.updatate.password2){
        this.$message.error("两次密码 不一致")
        return
      }
      this.$axios('/user/updatePassword?username='+this.$store.state.username +'&password='+this.updatate.password1).then(res=>{
        if (res.data == true || res.data =='true'){
          this.$message.success("修改成功")
          return
        }

        this.$message.error("服务端异常")
      })
    }
  },
  created() {
    this.name = this.$store.state.name;
  }
}
</script>

<style>
.lin > input{
  color: black;
}
</style>
<style scoped>
</style>
