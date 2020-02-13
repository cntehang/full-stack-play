const TODO_ID_ATTR = 'data-todo-id'
const selectorIds = `input[${TODO_ID_ATTR}]`
const selectorChecked = `${selectorIds}:checked`

const selected_form$ = $('#selected_form')

const info_dialog$ = $('#info_dialog')


$('#showSelectedBtn').click(function (event) {
  const checkedItems$ = $(selectorChecked)
  if (checkedItems$.length < 1) {
    info_dialog$.modal("show")
    event.preventDefault()
  }
})

// put the selected ids before submit
// have to append multiple inputs because
// Play requires "[]"" as a postfix for an array field
// and each value is separate
selected_form$.submit(function () {
  const checkedItems$ = $(selectorChecked)
  checkedItems$.each(function () {
    const id = $(this).attr(TODO_ID_ATTR)
    const newInput = $('<input>', {
      type: 'hidden',
      name: 'ids[]', // must be the same as backedn
      value: id,
    });
    selected_form$.append(newInput)
  })
})

$('#select_all_btn').click(function () {
  $(selectorIds).each(function () {
    $(this).prop('checked', true)
  })
})

$('#unselect_all_btn').click(function () {
  $(selectorIds).each(function () {
    $(this).prop('checked', false)
  })
})
