import Vue from 'vue'
import Router from 'vue-router'

import Login from '../components/login'
import Reg from '../components/reg'
import Select from "@/components/select";
import Home from "@/components/home/home";
import PhotoWall from "@/components/home/PhotoWall";
import adminLogin from "@/components/admin/adminLogin";
import homework from "@/components/homework/homework";
import user from "@/components/home/user";
import LeagueTables from "@/components/home/LeagueTables";
import JobDetails from "@/components/homework/JobDetails";
import PhotosDetails from "@/components/home/PhotosDetails";
import adminHome from "@/components/admin/adminHome";
import updateReview from "@/components/admin/management/updateReview";
import sonHomeWork from "@/components/home/sonHomeWork";

Vue.use(Router)
export default new Router({
    routes:[
        {
            name:'Login',
            path:'/',
            component:Login
        },
        {
            name:'adminLogin',
            path:'/adminlogin',
            component:adminLogin
        },
        {
            name:'Reg',
            path:'/reg',
            component:Reg
        },
        {
            name:'Select',
            path:'/select',
            component:Select
        },
        ,
        {
            name:'Home',
            path:'/home',
            component:Home,
            children:[
                {
                    name:'PhotoWall',
                    path:'photoWall',
                    component:PhotoWall
                },
                {
                    name:'Homework',
                    path:'homework',
                    component: homework
                },
                {
                    name:'user',
                    path:'user',
                    component: user
                },
            //    LeagueTables PhotosDetails
                {
                    name:'LeagueTables',
                    path:'leaguetables',
                    component: LeagueTables
                },
                {
                    name:'JobDetails',
                    path:'jobdetails',
                    component: JobDetails
                },
                {
                    name:'PhotosDetails',
                    path:'photosdetails',
                    component: PhotosDetails
                },
                // sonHomeWork
                {
                    name:'sonHomeWork',
                    path:'sonHomeWork',
                    component: sonHomeWork
                }
            ]
        },
        {
            name:'adminHome',
            path:'/adminHome',
            component:adminHome
        },
        {
            name:'updateReview',
            path:'/updatereview',
            component: updateReview
        },
    ]
})
