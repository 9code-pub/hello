module.exports = function(grunt) {

  // ����Grunt����ģ��Ĳ���
  grunt.initConfig({
    clean: [
      'dist'
    ],
    jshint: {},
    concat: {
      options: {
        separator: ';',
        sourceMap: true
      },
      dist: {
        src: [
          'public/components/jquery/dist/jquery.js',
          'public/components/underscore/underscore.js',
          'public/components/backbone/backbone.js'
        ],
        dest: 'dist/components.min.js'
      },
      min: {
        src: [
          'public/components/jquery/dist/jquery.min.js',
          'public/components/underscore/underscore-min.js',
          'public/components/backbone/backbone-min.js'
        ],
        dest: 'dist/components.min.js'
      }
    },
    uglify: {
      options: {
        mangle: true,
        beautify: true
      },
      target: {
        expand: true,
        cwd: 'boilerplate/js/',
        src: ['*.js', '!*.min.js'],
        dest: 'dist/js/',
        ext: '.min.js'
      }
    },
    cssmin: {
      minify: {
        expand: true,
        cwd: 'boilerplate/css/',
        src: ['*.css', '!*.min.css'],
        dest: 'dist/css/',
        ext: '.min.css'
      },
      combine: {
        files: {
          'dist/css/public.min.css': [
            'public/components/bootstrap/dist/css/bootstrap.min.css',
            'public/components/bootstrap/dist/css/bootstrap-theme.min.css'
          ]
        }
      }
    },
    watch:  { /* watch�Ĳ��� */ }
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
  grunt.registerTask('default', ['concat', 'uglify']);
  grunt.registerTask('check', ['jshint']);
  grunt.registerTask('css', ['cssmin:minify','cssmin:combine']);

};