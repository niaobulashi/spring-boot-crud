// 设置全局表单提交模式
Vue.http.options.emulateJSON=true;

new Vue({
    el: '#app',
    data() {
        return {
            // element-ui的table需要的参数必须是Array类型的
            goods: [{
                id: '',
                title: '',
                price: '',
                image: '',
                brand: ''
            }],

            // 编辑表
            editor: {
                title: '',
                price: '',
                image: '',
                brand: ''
            },

            // 添加dialog
            showSave: false,
            // 编辑dialog
            showEditor: false,

            // 条件查询单独封装的对象
            searchEntity: {},

            // checkbox选择的行中所有数据，将会放入multipartSelection数组中
            selectIds: [], //将checkbox选择的id值，用户批量删除
            count: 0, //tag栏，此项表示checkbox选择的几行

            // 分页选项
            pageConf: {
                // 设置一些初始值
                pageCode: 1, //当前页
                pageSize: 6, //每页显示的记录数
                totlePage: 12, //总记录数
                pageOption:[6, 10, 20], //分页选项
            },

            loading: {},

            // 文件上传参数
            dialogImageUrl: '',
            dialogVisible: false,
            // 图片列表（用户回显图片）
            fileList: [{name:'', url:''}],
            activeIndex: '2', //默认激活
        }
    },
    methods: {
        /**
         * loading加载动画
         */
        loadings() {
            this.loading = this.$loading({
                lock: true,
                text: '拼命加载中',
                spinner: 'el-icon-loading',
            });
            setTimeout(() => {
                this.loading.close();
            }, 2000);
        },

        /**
         * 刷先列表
         */
        reloadList() {
            console.log("totalPage:" + this.pageConf.totlePage + ",pageSize:" + this.pageConf.pageSize + ",pageCode:" + this.pageConf.pageCode);
            this.search(this.pageConf.pageCode, this.pageConf.pageSize);
        },

        /**
         * 条件查询
         */
        search(pageCode, pageSize) {
            this.loadings();
            this.$http.post('/goods/findByConPage?pageCode=' + pageCode + '&pageSize=' + pageSize, this.searchEntity).then(result => {
                console.log(result);
                this.goods = result.body.rows;
                this.pageConf.totlePage = result.body.total;
                // 数据查询完后关闭加载动画
                this.loading.close();
            });
        },
        // checkbox复选框
        selectChange(val) {
            this.count = val.length;
            this.multipleSelection = val;
        },
        // 清空已选择
        clearSelect() {
            this.$refs.goods.clearSelection();
        },
        // pageSize改变时触发的函数
        handleSizeChange(val) {
            this.search(this.pageConf.pageCode, val);
        },
        // 改变页面时触发的函数
        handleCurrentChange(val) {
            this.pageConf.pageCode = val;
            // 为了保证刷新列表后页面还是当前页，而不是跳转到第一页
            this.search(val, this.pageConf.pageSize);
        },
        // 更新
        sureEdit
    }
})