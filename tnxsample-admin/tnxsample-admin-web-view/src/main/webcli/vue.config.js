// vue.config.js
module.exports = {
    publicPath: './',
    outputDir: '../webapp/static',
    assetsDir: 'assets',
    devServer: {
        port: 8087
    },
    pages: {
        index: {
            entry: 'src/main.js',
            template: 'public/index.html',
            filename: 'main.html',
            minify: false, // 不压缩html代码
        }
    },
}
