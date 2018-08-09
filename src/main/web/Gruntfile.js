module.exports = function(grunt) 
{
  grunt.initConfig({
    pkg: grunt.file.readJSON("package.json"),

    watch:
    {
      sass:
      {
        files:['sass/**/*.sass','!sass/style.sass'],
        tasks:['concat:sass','compass','cssmin'],
        options: 
        {
          spawn: false,
          livereload: true,
          livereload: 35730,
          livereloadOnError: false
        }
      },
      js:
      {
        files:['js/**/*.js','!js/main/main.*'],
        tasks:['concat:js','jshint','uglify'],
        options: 
        {
          spawn: false,
          jshintrc: true,
          livereload: true,
          livereload: 35730,
          livereloadOnError: false
        }
      },
      html: 
      {
        files: ['index.html','views/**/*.html'],
        tasks: ['htmlhint'],
        options: 
        {
          spawn: false,
          livereload: true,
          livereload: 35730,
          livereloadOnError: false
        }
      }
    },

    jshint:
    {
      options : 
      {
        reporter: 'jslint',
        force: 'true',
        reporterOutput: 'js/main/errors.log'        
      },
      all: ['js/main/main.js'],
    },

    compass : 
    {
      dist: 
      {
        options: 
        {
          config: 'config.rb'
        }
      }
    },

    htmlhint: 
    {
      indexFiles: 
      {
          options: 
          {
            'tagname-lowercase': true,
            'attr-lowercase': true,
            'attr-value-double-quotes': true,
            'attr-value-not-empty': true,
            'attr-no-duplication': true,
            'tag-pair': true,
            'tag-self-close': true,
            'spec-char-escape': true,
            'id-unique': true,
            'src-not-empty': true,
            'title-require': true
          },
          src: ['index.html','views/**/*.html']
      }
    },

    concat: 
    {
      js:
      {
        src: ['js/**/*.js','!js/main/main.*'],
        dest: 'js/main/main.js',
        options: 
        {
          separator: '\n\n'
        }
      },
      sass: 
      {
        src: ['sass/**/*.sass','!sass/style/style.sass'],
        dest: 'sass/style/style.sass',
        options: 
        {
          separator: '\n\n'
        }
      },
    },

    uglify: 
    {
      options: 
      {
        mangle: false
      },
      my_target: 
      {
        files: 
        [{
          expand: true,
          cwd: 'js/main/',
          src: 'main.js',
          dest: '../resources/public/js/',
          ext: '.min.js'
        }]
      }
    },

    cssmin: 
    {
      target: 
      {
        files: 
        [{
          expand: true,
          cwd: 'css/',
          src: 'style.css',
          dest: '../resources/public/css/',
          ext: '.min.css'
        }]
      }
    }
  });

  grunt.loadNpmTasks('grunt-contrib-compass');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-htmlhint');

  grunt.registerTask('default', ['htmlhint','jshint','concat','compass','uglify','cssmin','watch']);
};