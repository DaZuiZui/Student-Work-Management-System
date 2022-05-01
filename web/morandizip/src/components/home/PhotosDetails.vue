<template>
  <div>
    <div class="mydiv" style="margin: 15px">
      <el-card shadow="hover" style="text-align: center">
        {{context}}
      </el-card>
    </div>
    <div class="mydiv" style="margin: 15px">
      <el-card shadow="hover">

        <div style="margin: 10px">  评论区:</div>
        <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="ly.zpdly">
        </el-input>
        <div style="text-align: center;margin: 16px">
          <el-button @click="fqly()">发布评论</el-button>
        </div>
        <el-divider>评论</el-divider>
        <div v-for="itme in lylit">
          <el-descriptions :title=itme.username>
            <el-descriptions-item >{{itme.zpdly}}</el-descriptions-item>
          </el-descriptions>
        </div>
      </el-card>
    </div>

    <div class="mydiv">
      <el-card shadow="hover" >
        <div class="block" style="margin: 5px">
          <el-image :src="src"></el-image>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "PhotosDetails",
  data(){
    return{
      src: 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg',
      context:'描述',
      id:'',
      lylit: [],
      commentsList:[
        {
          id:'-1',
          name:'绑定的name',
          user_id:'-1',
          blog_id : '-1',
          text :''
        }
      ],
      ly: {
        zpdly : '',
        zpqid : '',
        username: '',
      }
    }
  },
  created() {
    this.src = this.$route.query.row.imaurl;
    this.id=this.$route.query.row.id
    this.context =this.$route.query.row.miaoshu
    this.getarlist();
  },
  methods: {
    getarlist(){
      this.$axios.get("/zpq/cxpinglun?zpqid="+this.id)
          .then(res => {
            console.log(res.data);
            this.lylit = res.data;
          })
    },

    fqly(){
      this.ly.zpqid = this.id;
      this.ly.username =  this.$store.state.username;

      this.$axios.post("/zpq/addly",this.ly)
          .then(res => {
            this.getarlist();
          })
    }
  }
}
</script>

<style scoped>

</style>
