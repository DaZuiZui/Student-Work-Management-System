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
                    <div style="text-indent: 30px;letter-spacing: 40px;  font-weight: 900;color: #a2f1b3; font-size: 30px">注册账号</div>
                  </el-card>
                </div>

              </div>
              <div style="height: 20px"></div>
              <div class="mydiv">
                <el-card>
                  <el-input class="myinupt" v-model="user" placeholder="请输入你的用户名" suffix-icon="el-icon-user"></el-input>
                  <div style="height: 30px"></div>
                  <el-input class="myinupt" v-model="username" placeholder="输入您的账号" suffix-icon="el-icon-user"></el-input>

                  <div style="height: 30px"></div>
                  <el-input class="myinupt" v-model="password" placeholder="输入您的密码" show-password ></el-input>
                  <div style="height: 20px"></div>
                  <div v-if="role=='parents'">
                    <div style="height: 30px"></div>
                    <el-input class="myinupt" v-model="sonusername" placeholder="请输入您孩子的账号"  ></el-input>
                    <div style="height: 20px"></div>
                  </div>

                  <el-row :gutter="20">
                    <el-col :span="5"><div class="grid-content bg-purple">&nbsp;</div></el-col>
                    <el-col :span="15"><div class="grid-content bg-purple">
                      <el-button @click="back" round style="background: #afe8bb;color: #ffffff; border: 0px; font-weight: 900;">&nbsp;返回&nbsp;</el-button>
                      <el-button  @click="reg" round style="background: #afe8bb;color: #ffffff; border: 0px;font-weight: 900;">&nbsp;注册&nbsp;</el-button>
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
  name: "reg",
  data(){
    return{
      user:'',
      username:'',
      password:'',
      sonusername:'',
      role:'',
    }
  },
  methods:{
    back(){
      this.$router.push({
        path:'/'
      })
    },
    reg(){
      let Rrole ;
      if (this.role == 'parents'){
        Rrole = 'guardian';
      }
      //student
      if (this.role == 'student'){
        Rrole = 'student';
      }
      let data ={username:this.username , password:this.password, name:this.name,sonusername:this.sonusername,role:Rrole}
      this.$axios.post('/user/reg',data).then(res=>{
        if (res.data == true || res.data == 'true'){
          this.$message.success('注册成功');
          this.$router.push({
            path: '/'
          })
          return
        }
        this.$message.error('账号已经被注册了')
      })
    }
  },
  created() {
    this.role = this.$route.query.role
  }
}
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
