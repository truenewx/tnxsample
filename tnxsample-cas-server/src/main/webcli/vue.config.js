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
            entry: 'src/main.js',
            template: 'public/index.html',
            filename: 'index.html'
        },
        decorator: {
            entry: 'src/main.js',
            template: 'public/decorator.html',
            filename: 'decorator.html'
        }
    },
}
