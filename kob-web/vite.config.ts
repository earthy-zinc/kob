import { resolve } from 'path'
import {ConfigEnv, defineConfig, loadEnv, UserConfig} from 'vite'
import Vue from '@vitejs/plugin-vue'
import Components from 'unplugin-vue-components/vite'
import AutoImport from 'unplugin-auto-import/vite'

// eslint-disable-next-line @typescript-eslint/ban-ts-comment
// @ts-expect-error
import DefineOptions from 'unplugin-vue-define-options/vite'
import { NaiveUiResolver } from 'unplugin-vue-components/resolvers'
import UnoCSS from 'unocss/vite'

export default defineConfig(({ mode }: ConfigEnv): UserConfig => {
  const env = loadEnv(mode, process.cwd())
  return {
    resolve: {
      alias: {
        '~/': `${resolve(__dirname, 'src')}/`,
      },
    },
    server: {
      host: '0.0.0.0',
      port: 3333,
      open: true, // 运行是否自动打开浏览器
      proxy: {
        // 反向代理解决跨域
        [env.VITE_APP_BASE_API]: {
          target: 'http://localhost:3000',
          changeOrigin: true,
          rewrite: path =>
            path.replace(
              new RegExp(`^${env.VITE_APP_BASE_API}`),
              '',
            ), // 替换 /dev-api 为 target 接口地址
        },
      },
    },
    plugins: [
      UnoCSS(),
      Vue({
        reactivityTransform: true,
      }),
      DefineOptions(),
      AutoImport({
        imports: [
          'vue',
          'vue-router',
          'vue/macros',
          '@vueuse/head',
          '@vueuse/core',
          'pinia',
        ],
        dts: 'src/auto-imports.d.ts',
        dirs: [
          'src/server/api',
          'src/composables',
          'src/store',
        ],
        vueTemplate: true,
      }),
      Components({
        resolvers: [
          NaiveUiResolver(),
        ],
        dts: 'src/components.d.ts',
      }),
    ],
  }
})
