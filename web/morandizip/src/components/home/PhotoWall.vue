<template>
<div>
  <el-button type="primary" round @click="drawer = true">添加照片墙</el-button>
  <el-drawer
      title="我是标题"
      :visible.sync="drawer"
      :with-header="false">
    <div style="font-size: 25px;margin-left: 150px;margin-top: 40px">添加照片墙</div>
    <div style="margin-left: 150px; margin-top: 25px">
      <el-upload
          :action="'http://127.0.0.1:8989/zpq/getimage?username='+this.$store.state.username"
          name="files"
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          limit="1"
          :on-success="yes"
          :on-remove="handleRemove">
        <i class="el-icon-plus"></i>
      </el-upload>

      <el-dialog :visible.sync="dialogVisible">
        <img width="100%" :src="dialogImageUrl" alt="">
      </el-dialog>

       </div>
    <div style="margin-top: 25px">
      <el-input
          type="textarea"
          :rows="2"
          placeholder="请输入内容"
          v-model="da.miaoshu">
      </el-input>
      <el-row :gutter="20">
        <el-col :span="10"><div class="grid-content bg-purple">&nbsp;</div></el-col>
        <el-col :span="6"><div class="grid-content bg-purple">
          <el-button type="primary" style="margin-top: 12px" round @click="addPC">添加</el-button>
        </div></el-col>
      </el-row>

    </div>

  </el-drawer>
  <el-row :gutter="20">
    <el-col :span="20" style="margin: 8px">
      <div class="grid-content bg-purple">
        <el-row :gutter="20">
          <div class="mydiv" v-for="ar in zpq">
          <el-col :span="12"><div class="grid-content bg-purple" style="margin-top: 20px">
            <el-card shadow="hover" >
              <div class="block" style="margin: 5px">
                <el-image style="height: 500px" :src="ar.imaurl"></el-image>
              </div>
              <div style="text-align: center">
                <div>{{ar.miaoshu}}</div>
                <div>  <el-link type="success" @click="details(ar)">查看详情</el-link></div>
              </div>
            </el-card>
          </div></el-col>
          </div>
        </el-row>

      </div>
    </el-col>

  </el-row>

</div>
</template>

<script>
export default {
  name: "PhotoWall",
  data(){
    return{
      drawer:false,
      src: 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg',
      zpq: [],
      dialogImageUrl: '',
      dialogVisible: false,
      da: {
        imaurl: '',
        miaoshu: '',
        username: '',
      }
    }
  },
  methods:{
    yes(response, file, fileList){
       this.da.imaurl = response;
       this.username = this.$store.state.username;
    },

    details(row){
      this.$router.push({
        path: '/home/photosdetails',
        query:{
          row:row
        }
      })
    },
    getzhaopianqiang(){
       this.$axios("/getwenzhang")
      .then(res => {
          this.zpq = res.data;
      })
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    addPC(){
      this.$axios.post('/zpq/insertdate',this.da).then(res=>{
        this.$message.success("添加成功")
        this. getzhaopianqiang();
        this.drawer = false;
      })
    }


  },created() {
   this. getzhaopianqiang();

  }
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
