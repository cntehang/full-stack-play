const TODO_ID_ATTR = 'data-todo-id'
const selectorIds = `input[${TODO_ID_ATTR}]`
const selectorChecked = `${selectorIds}:checked`

// put the selected ids before submit
$('#selected_form').submit(function () {
  const selected = []
  $(selectorChecked).each(function () {
    const id = $(this).attr(TODO_ID_ATTR)
    selected.push(id)
  })

  $('#ids').val(selected)
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
