const webpack = require('webpack');
const HtmlWebPackPlugin = require("html-webpack-plugin");
const path = require('path');

const isVerbose = true;
const PROXY_TARGET = 'scheduler:9000';

module.exports = {
    entry: './src/entrypoint.js',
    output: {
        path: path.resolve(__dirname, './build'),
        publicPath: '/',
        filename: '[name].js?[hash]',
        chunkFilename: '[id].js?[chunkhash]',
    },

    devtool: 'source-map',

    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/i,
                use: {
                    loader: "babel-loader"
                }
            },
            {
                test: /\.html$/,
                use: [
                    {
                        loader: "html-loader"
                    }
                ]
            }
        ]
    },
    plugins: [
        new HtmlWebPackPlugin({
            template: "./public/index.html",
            filename: "./index.html"
        }),
        new webpack.HotModuleReplacementPlugin()
    ],

    devServer: {
        host: "0.0.0.0",
        publicPath: '/',
        historyApiFallback: true,
        contentBase: path.resolve(__dirname, 'build'),
        hot: true,
        watchOptions: {
            aggregateTimeout: 100
        },
        headers: {
            'Access-Control-Allow-Origin': '*'
        },
        proxy: {
            '/': {
                target: {
                    port: 9000,
                    host: 'gateway',
                    protocol: 'http:',
                },
                secure: false,
                changeOrigin: false
            }
        },
        // What and how information should be printed to the console
        stats: {
            assets: true,
            colors: true,
            cached: isVerbose,
            cachedAssets: isVerbose,
            chunks: isVerbose,
            chunkModules: isVerbose,
            errors: true,
            errorDetails: true,
            hash: true,
            timings: true,
            modules: isVerbose,
            reasons: true,
            version: true,
            warnings: false
        }
    }
};