// vue.config.js
module.exports = {
    publicPath: '/cas',
    outputDir: '../webapp/static',
    assetsDir: 'assets',
    devServer: {
        port: 8083
    },
    pages: {
        index: {
            entry: 'src/libs.js',
            template: 'public/libs.html',
            filename: 'libs.jsp',
            minify: false, // 不压缩html代码
        }
    },
}
