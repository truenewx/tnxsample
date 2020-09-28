// vue.config.js
module.exports = {
    publicPath: '/admin',
    outputDir: '../webapp/static',
    assetsDir: 'assets',
    indexPath: 'main.html',
    devServer: {
        port: 8087
    },
    pages: {
        index: {
            entry: 'src/main.js',
            template: 'public/index.html',
            filename: 'index.html', // 不能修改为其它值，否则页面无法正常打开，构建时被上面的indexPath覆盖
            minify: false, // 不压缩html代码
        }
    },
}
