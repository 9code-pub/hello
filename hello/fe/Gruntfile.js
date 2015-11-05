module.exports = function(grunt) {

  // ����Grunt����ģ��Ĳ���
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
          '!doc/*'],
        dest: 'dist/'
      }
    },
    concat: {
      options: {
        separator: ';',
        sourceMap: true
      },
      source: {
        src: [
          'src/js/*.js'
        ],
        dest: 'dist/js/concat.js'
      },
      components: {
        src: [
          'public/components/jquery/dist/jquery.js',
          'public/components/underscore/underscore.js',
          'public/components/backbone/backbone.js'
        ],
        dest: 'dist/js/components.js'
      },
      components_min: {
        src: [
          'public/components/jquery/dist/jquery.min.js',
          'public/components/underscore/underscore-min.js',
          'public/components/backbone/backbone-min.js'
        ],
        dest: 'dist/js/components.min.js'
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
      combine: {
        files: {
          'dist/css/components.min.css': [
            'public/components/bootstrap/dist/css/bootstrap.min.css',
            'public/components/bootstrap/dist/css/bootstrap-theme.min.css'
          ]
        }
      }
    },
    watch: {
      options: {
        cwd: 'src/'
      },
      files: ['js/*.js', 'css/*.css', '*.html'],
      tasks: ['copy', 'concat:source']
    }
  });

  // ��node_modulesĿ¼����ģ���ļ�
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-qunit');

  // ÿ��registerTask����һ������
  grunt.registerTask('default', ['concat', 'copy']);
  grunt.registerTask('release', ['concat', 'uglify']);
  grunt.registerTask('check', ['jshint']);
  grunt.registerTask('css', ['cssmin:minify','cssmin:combine']);

};