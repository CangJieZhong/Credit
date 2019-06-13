(function (vue) {
  // html模板信息
  var template = '<div class="page-bar"> \
           <ul> \
            <li><a class="{{ setbuttonclass(0) }}" v-on:click="prvepage(cur)">上一页</a></li> \
            <li v-for="index in indexs" v-bind:class="{ active: cur == index }"> \
             <a v-on:click="btnclick(index)">{{ index < 1 ? "..." : index }}</a> \
            </li> \
            <li><a class="{{ setbuttonclass(1) }}" v-on:click="nextpage(cur)">下一页</a></li> \
           </ul> \
          </div>'
  var pagination = vue.extend({
    template: template,
    props: ['cur', 'all'],
    computed: {
      indexs: function () {
        var left = 1
        var right = this.all
        var ar = []
        if (this.all >= 11) {
          if (this.cur > 5 && this.cur < this.all - 4) {
            left = this.cur - 5
            right = this.cur + 4
          } else {
            if (this.cur <= 5) {
              left = 1
              right = 10
            } else {
              right = this.all
              left = this.all - 9
            }
          }
        }
        while (left <= right) {
          ar.push(left)
          left++
        }
        if (ar[0] > 1) {
          ar[0] = 1;
          ar[1] = -1;
        }
        if (ar[ar.length - 1] < this.all) {
          ar[ar.length - 1] = this.all;
          ar[ar.length - 2] = 0;
        }
        return ar
      }
    },
    methods: {
      // 页码点击事件
      btnclick: function (data) {
        if (data < 1) return;
        if (data != this.cur) {
          this.cur = data
          this.$dispatch('btn-click', data)
        }
      },
      // 下一页
      nextpage: function (data) {
        if (this.cur >= this.all) return;
        this.btnclick(this.cur + 1);
      },
      // 上一页
      prvepage: function (data) {
        if (this.cur <= 1) return;
        this.btnclick(this.cur - 1);
      },
      // 设置按钮禁用样式
      setbuttonclass: function (isnextbutton) {
        if (isnextbutton) {
          return this.cur >= this.all ? "page-button-disabled" : ""
        }
        else {
          return this.cur <= 1 ? "page-button-disabled" : ""
        }
      }
    }
  })
  vue.pagination = pagination
})(vue)

