module.exports = function(grunt) {

  // ����Grunt����ģ��Ĳ���
  grunt.initConfig({
    jshint: { /* jshint�Ĳ��� */ },
    concat: { /* concat�Ĳ��� */ },
    uglify: { /* uglify�Ĳ��� */ },
    watch:  { /* watch�Ĳ��� */ }
  });

  // ��node_modulesĿ¼����ģ���ļ�
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-qunit');

  // ÿ��registerTask����һ������
  grunt.registerTask('default', ['jshint', 'concat', 'uglify']);
  grunt.registerTask('check', ['jshint']);

};