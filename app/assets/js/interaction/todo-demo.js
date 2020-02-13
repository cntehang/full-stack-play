const TODO_ID_ATTR = 'data-todo-id'
const selector = `input[${TODO_ID_ATTR}]:checked`
const SELECTED_URL = 'http://localhost:9000/interaction/todos/selected'

$('#showSelectedBtn').click(function () {
  let selected = []
  $(selector).each(function () {
    selected += $(this).attr(TODO_ID_ATTR)
  })

  const data = JSON.stringify(selected)

  $.ajax({
    type: 'POST',
    url: SELECTED_URL,
    contentType: 'application/json',
    data: data,
    success: selectSuccess,
  })

  function selectSuccess(data) {
    alert("Returned: " + data)
  }
})
