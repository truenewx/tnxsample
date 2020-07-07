// vue.config.js
module.exports = {
    publicPath: '/cas',
    outputDir: '../webapp/static',
    assetsDir: 'assets',
    indexPath: 'index.jsp', // 使用JSP页面作为装饰页才能正常post提交表单
    devServer: {
        port: 8083
    },
}
