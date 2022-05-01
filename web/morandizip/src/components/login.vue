<template>
<div>
<div style="height: 150px"></div>
  <el-row :gutter="30">
    <el-col :span="7"><div class="grid-content bg-purple">&nbsp;</div></el-col>
    <el-col :span="16"><div class="grid-content bg-purple">
      <el-row :gutter="100">
        <el-col :span="2"><div class="grid-content bg-purple">&nbsp;</div></el-col>
        <el-col :span="50"><div class="grid-content bg-purple">
          <div>
            <div class="rcorners1">
              <div class="mydiv">
                <el-card >
                  <div style="text-indent: 30px;letter-spacing: 40px;  font-weight: 900;color: #a2f1b3; font-size: 30px">登录账号</div>
                </el-card>
              </div>
            </div>
            <div style="height: 20px"></div>
            <div class="mydiv">
              <el-card>
                <el-input class="myinupt" v-model="username" placeholder="输入您的账号" suffix-icon="el-icon-user"></el-input>
                <div style="height: 30px"></div>
                <el-input class="myinupt" v-model="password" placeholder="输入您的密码" show-password ></el-input>
                <div style="height: 20px"></div>
                <el-row :gutter="20">
                  <el-col :span="5"><div class="grid-content bg-purple">&nbsp;</div></el-col>
                  <el-col :span="15"><div class="grid-content bg-purple">
                    <el-button round style="background: #afe8bb;color: #ffffff; border: 0px; font-weight: 900;" @click="loginA">&nbsp;登录&nbsp;</el-button>
                    <el-button round style="background: #afe8bb;color: #ffffff; border: 0px;font-weight: 900;" @click="goReg">&nbsp;注册&nbsp;</el-button>
                  </div></el-col>
                </el-row>

              </el-card>
            </div>

          </div>
        </div></el-col>
      </el-row>
    </div></el-col>
  </el-row>
</div>
</template>

<script>
export default {
  name: "login",
  data(){
    return{
        ui: "myinupt",
      username:'',
      password:''
    }
  },
  methods:{
    goReg(){
      this.$router.push({
        path:'/select'
      })
    },
    loginA(){
      let usr ={username:this.username , password:this.password} ;
      this.$axios.post('/user/login',usr).then(res=>{
        if ( res.data !=null){
          this.$message.success('登录成功');
          this.$store.dispatch('setUsername',res.data.username);
          this.$store.dispatch('setName',res.data.name);
          this.$store.dispatch('setRole',res.data.role);
          this.$store.dispatch('setImgUrl',res.data.imaurl);
          this.$store.dispatch('setSonusername',res.data.sonusername);
          console.log(res.data)
          console.log(this.$store.state.username)
          console.log(this.$store.state.imaurl)
          this.$router.push({
            path:'/home'
          })
          return
        }
        this.$message.error('账号或 密码错误');
      })
    }
  }
}
//  border-radius: 300px;
</script>

<style>
.myinupt > input{
  border-radius: 300px;
  color: #ffffff;
  background: #afe8bb;
  outline: none;
  border: 0px;

}
.myinupt>input::placeholder  {
  color: #ffffff;
}
.mydiv > div{
  border-radius: 25px;
}
.mydiv2 > div{
  border-radius: 25px;
  margin-up: 20px;
}
.el-input__inner{
  color: #fff;
  text-align:center;
}

</style>
