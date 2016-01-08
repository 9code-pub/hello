module.exports = function(grunt) {

  // 配置Grunt各种模块的参数
  grunt.initConfig({
    clean: [
      'dist'
    ],
    jshint: {},
    copy: {
      options: {
        encoding: 'utf-8',
        timestamp: true
      },
      dist: {
        expand: true,
        cwd: 'src/',
        src: ['**',
          '!.gitignore',
          '!LICENSE.txt',
          '!doc/*',
          '!css/*',
          '!js/*'],
        dest: 'dist/'
      },
      components_bootstrap: {
        expand: true,
        cwd: 'bower_components/bootstrap/dist/',
        src: ['fonts/*'],
        dest: 'dist/'
      }
    },
    concat: {
      options: {
        separator: ';\n',
        sourceMap: true
      },
      js: {
        src: [
          'src/js/*.js'
        ],
        dest: 'dist/js/main.js'
      },
      css: {
        src: [
          'src/css/*.css'
        ],
        dest: 'dist/css/main.css'
      },
      components: {
        src: [
          'bower_components/jquery/dist/jquery.js',
          'bower_components/bootstrap/dist/js/bootstrap.js',
          'bower_components/underscore/underscore.js',
          'bower_components/backbone/backbone.js'
        ],
        dest: 'dist/js/external.js'
      },
      components_min: {
        src: [
          'bower_components/jquery/dist/jquery.min.js',
          'bower_components/bootstrap/dist/js/bootstrap.min.js',
          'bower_components/underscore/underscore-min.js',
          'bower_components/backbone/backbone-min.js'
        ],
        dest: 'dist/js/external.min.js'
      }
    },
    uglify: {
      options: {
        mangle: true,
        beautify: true
      },
      target: {
        expand: true,
        cwd: 'src/js/',
        src: ['*.js', '!*.min.js'],
        dest: 'dist/js/',
        ext: '.min.js'
      }
    },
    cssmin: {
      minify: {
        expand: true,
        cwd: 'src/css/',
        src: ['*.css', '!*.min.css'],
        dest: 'dist/css/',
        ext: '.min.css'
      },
      components: {
        files: {
          'dist/css/external.css': [
            'bower_components/bootstrap/dist/css/bootstrap.css',
            'bower_components/bootstrap/dist/css/bootstrap-theme.css'
          ]
        }
      },
      components_min: {
        files: {
          'dist/css/external.min.css': [
            'bower_components/bootstrap/dist/css/bootstrap.min.css',
            'bower_components/bootstrap/dist/css/bootstrap-theme.min.css'
          ]
        }
      }
    },
    watch: {
      options: {
        cwd: 'src/'
      },
      files: ['js/*.js', 'css/*.css', '*.html', '*.js'],
      tasks: ['copy', 'concat']
    }
  });

  // 从node_modules目录加载模块文件
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-qunit');

  // 每行registerTask定义一个任务
  grunt.registerTask('default', ['concat', 'copy']);
  grunt.registerTask('release', ['concat', 'uglify']);
  grunt.registerTask('check', ['jshint']);
  grunt.registerTask('style', ['cssmin']);

};