import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
const actions = {
    setUsername(context,value){
        context.commit('SETUSERNAME',value);
    },
    setName(context,value){
        context.commit('SETNAME',value);
    },
    setRole(context,value){
        context.commit('SETROLE',value);
    },
    setImgUrl(context,value){
        context.commit('SETIMGURL',value);
    },
    setSonusername(context,value){
        context.commit('SETSONUSERNAME',value)
    }
}
const mutations={
    SETUSERNAME(state,value){
        state.username=value;
    },
    SETNAME(start,value){
        start.name =value;
    },
    SETROLE(start,value){
        start.role = value;
    },
    SETIMGURL(start ,value){
        start.imaurl = value;
    },
    SETSONUSERNAME(start,value){
        start.sonusername = value;
    }
}
const state={
    username:null,
    name:null,
    role:null,
    imaurl:'',
    sonusername:''
}
//创建VueX对象
export default new Vuex.Store({
    actions,
    mutations,
    state
})
